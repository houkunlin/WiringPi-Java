set(
        SOURCE_FILES
        com_wiringpi_jni_WiringPiSetup.cpp
        com_wiringpi_jni_WiringPi.cpp
        com_wiringpi_jni_SoftPwm.cpp
        com_wiringpi_jni_TestNative.cpp
        com_wiringpi_jni_SoftTone.cpp
        com_wiringpi_jni_WiringPiI2C.cpp
        Callback.cpp
        utils.cpp
)
set(
        SOURCE_HEADERS
        com_wiringpi_jni_WiringPiSetup.h
        com_wiringpi_jni_WiringPi.h
        com_wiringpi_jni_SoftPwm.h
        com_wiringpi_jni_TestNative.h
        com_wiringpi_jni_SoftTone.h
        com_wiringpi_jni_WiringPiI2C.h
        Callback.h
        utils.h
)
# 设置动态链接库的安装路径
set(CMAKE_INSTALL_PREFIX /usr/lib/ CACHE PATH "安装路径" FORCE)

add_library(WiringPi SHARED ${SOURCE_FILES} ${SOURCE_HEADERS})

MESSAGE(STATUS "=============================================")
MESSAGE(STATUS "output          dir: ${LIBRARY_OUTPUT_PATH}")
MESSAGE(STATUS "source        files: ${SOURCE_FILES}")
MESSAGE(STATUS "source header files: ${SOURCE_HEADERS}")
MESSAGE(STATUS "project         dir: ${PROJECT_SOURCE_DIR}")
MESSAGE(STATUS "=============================================")

# clean
set_target_properties(WiringPi PROPERTIES CLEAN_DIRECT_OUTPUT 1)
# 把库安装到指定的 ${CMAKE_INSTALL_PREFIX}/jni 路径（/usr/lib/jni）
install(TARGETS WiringPi LIBRARY DESTINATION "jni")
target_link_libraries(WiringPi)
