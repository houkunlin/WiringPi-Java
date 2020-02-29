#!/usr/bin/env bash

cmake -G "CodeBlocks - MinGW Makefiles" -B cmake-build -S .
cmake --build cmake-build
cmake --install cmake-build