@echo off
color 
TITLE Bienvenid@ INFORMATICA & TRIBUTOS
MODE con:cols=80 lines=40

:inicio
set var=0
cls
echo =================================================================================
echo                               BIENVENIDO
echo                     INFORMATICA Y TRIBUTOS - TEST CASE
echo                    Hecho por Roger Villalobos. Lider QA
echo                        %DATE% ^| %TIME%
echo.
echo =================================================================================

echo  1    Crear PQR 
echo  2    Salir
echo ---------------------------------------------------------------------------------
echo.

SET /p var= ^> Seleccione una opcion [1 o 2]:

if "%var%"=="0"   goto inicio
if "%var%"=="1"   goto op1
if "%var%"=="2"  goto salir

::Mensaje de error, validación cuando se selecciona una opción fuera de rango
echo. El numero "%var%" no es una opcion valida, por favor intente de nuevo.
echo.
pause
echo.
goto:inicio

:op1
    echo.
    echo. Has elegido la opcion No. 1
    echo.
      gradlew clean test --tests *com.src.test.java.runner.runner 
      
    echo.
    pause
    goto:inicio

:op2
   :salir
    @cls&exit