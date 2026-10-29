#!/bin/bash

FULL_NAME="Beibarys Borankul"
LOG_FILE="$(dirname "$0")/../logs/Borankul_Beibarys_system_report.log"

{
  echo "=============================="
  echo "System Report"
  echo "=============================="
  echo "Student: $FULL_NAME"
  echo "Date and time: $(date '+%Y-%m-%d %H:%M:%S')"
  echo "User: $(whoami)"
  echo "Operating system: $(grep PRETTY_NAME /etc/os-release | cut -d= -f2 | tr -d '"')"
  echo "Kernel: $(uname -r)"
  echo "CPU: $(lscpu | grep 'Model name' | sed 's/Model name:[ ]*//')"
  echo "CPU cores: $(nproc)"
  echo "Memory: $(free -h | awk '/Mem:/ {print $3 " used of " $2 " (" $7 " available)"}')"
  echo "Disk usage: $(df -h / | awk 'NR==2 {print $3 " used of " $2 " (" $5 ")"}')"
  echo "Available disk space: $(df -h / | awk 'NR==2 {print $4}')"
  echo
} | tee -a "$LOG_FILE"
