cmake_minimum_required(VERSION 3.6)
project(WiringPi)

# 在树莓派中使用的Java路径是： /usr/lib/jvm/java-11-openjdk-armhf/
set(JAVA_HOME "/usr/lib/jvm/java-11-openjdk-armhf/")

message(STATUS "ENV JAVA_HOME $ENV{JAVA_HOME}")
message(STATUS "VAR JAVA_HOME ${JAVA_HOME}")
include_directories(
        SYSTEM
        "$ENV{JAVA_HOME}/include"
        "$ENV{JAVA_HOME}/include/win32"
        "$ENV{JAVA_HOME}/include/linux"
        "${JAVA_HOME}/include"
        "${JAVA_HOME}/include/win32"
        "${JAVA_HOME}/include/linux"
        "${PROJECT_SOURCE_DIR}/include"
)

set(BUILD_USE_64BITS on)
if (CMAKE_COMPILER_IS_GNUCXX)
    set(CMAKE_CXX_FLAGS "-std=c++11 ${CMAKE_CXX_FLAGS}")
    message(STATUS "optional: -std=c++11")
endif (CMAKE_COMPILER_IS_GNUCXX)

add_compile_options("-fms-extensions")
# 连接系统标准库
link_libraries(-lwiringPi -lpthread)

add_subdirectory(lib)
