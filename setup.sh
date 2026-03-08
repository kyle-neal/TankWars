#!/usr/bin/env bash
set -e

echo "============================="
echo "  TankWars Setup Script"
echo "============================="
echo ""

# --- Check for root/sudo ---
if [ "$(id -u)" -eq 0 ]; then
    SUDO=""
else
    if command -v sudo &>/dev/null; then
        SUDO="sudo"
    else
        echo "Error: This script requires root privileges. Please run as root or install sudo."
        exit 1
    fi
fi

# --- Install JDK 17 ---
echo "[1/3] Checking Java installation..."
if java -version 2>&1 | grep -q 'version "17'; then
    echo "  Java 17 is already installed."
else
    echo "  Installing OpenJDK 17..."
    $SUDO apt-get update -qq
    $SUDO apt-get install -y -qq openjdk-17-jdk > /dev/null
    $SUDO update-alternatives --set java /usr/lib/jvm/java-17-openjdk-amd64/bin/java 2>/dev/null || true
    $SUDO update-alternatives --set javac /usr/lib/jvm/java-17-openjdk-amd64/bin/javac 2>/dev/null || true
    echo "  OpenJDK 17 installed."
fi

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# --- Install Gradle ---
echo "[2/3] Checking Gradle installation..."
if command -v gradle &>/dev/null; then
    echo "  Gradle is already installed."
else
    echo "  Installing Gradle..."
    $SUDO apt-get update -qq
    $SUDO apt-get install -y -qq gradle > /dev/null
    echo "  Gradle installed."
fi

# --- Install Make ---
if ! command -v make &>/dev/null; then
    echo "  Installing Make..."
    $SUDO apt-get install -y -qq make > /dev/null
fi

# --- Build ---
echo "[3/3] Building TankWars..."
cd "$(dirname "$0")"
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
gradle build
echo ""
echo "============================="
echo "  Build Successful!"
echo "============================="
echo ""

# --- Prompt to run ---
if [ -t 0 ]; then
    read -rp "Would you like to run TankWars now? [y/N] " answer
else
    answer="n"
fi
case "$answer" in
    [yY]|[yY][eE][sS])
        echo "Launching TankWars..."
        java -jar build/libs/TankWars.jar
        ;;
    *)
        echo ""
        echo "To run later, use one of:"
        echo "  make run"
        echo "  make clean-run"
        echo "  java -jar build/libs/TankWars.jar"
        ;;
esac
