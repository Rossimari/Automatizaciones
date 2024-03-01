@echo off
REM chcp para permitir los acentos UTF-8
chcp 65001 > nul
color 
TITLE Bienvenid@ INFORMATICA & TRIBUTOS
MODE con:cols=62 lines=30

:menu_principal
set var=0
cls
echo ==============================================================
echo                             BIENVENIDO
echo                  INFORMATICA Y TRIBUTOS - TEST CASE
echo                        Hecho por equipo de QA
echo                    %DATE% ^| %TIME%
echo.
echo ==============================================================
echo                        Menú de Opciones
echo ==============================================================
echo 1. Generación Del Tributo
echo 2. Gestión Financiera
echo 3. PQR
echo 0. Salir
echo ==============================================================
set /p option=Por favor seleccione una opción:

REM Validación de entrada
if "%option%"=="1" goto menu_generacion_del_tributo
if "%option%"=="2" goto menu_gestion_financiera
if "%option%"=="3" goto menu_pqr
if "%option%"=="0" goto :EOF

echo Opción no válida. Por favor, seleccione una opción válida.
pause
goto menu_principal

	REM ----------------------------------------------------------------------------
	REM ---------------------1.MENÚ GENERACION DEL TRIBUTO----------------------------
	REM ----------------------------------------------------------------------------
	:menu_generacion_del_tributo
	cls
	echo ==============================================================
	echo                             BIENVENIDO
	echo                  INFORMATICA Y TRIBUTOS - TEST CASE
	echo                        Hecho por equipo de QA
	echo                    %DATE% ^| %TIME%
	echo.
	echo ==============================================================
	echo                   Menú Generación Del Tributo
	echo ==============================================================
	echo 1. Rentas Varias
	echo 2. Ir Al Menú Principal
	echo 0. Salir
	echo ==============================================================
	set /p option=Por favor seleccione una opción:

	REM Validación de entrada
	if "%option%"=="1" goto sub_menu_rentas_varias
	if "%option%"=="2" goto menu_principal
	if "%option%"=="0" goto :EOF

	echo Opción no válida. Por favor, seleccione una opción válida.
	pause
	goto menu_principal
	
		REM ----------------------------------------------------------------------------
		REM ---------------------SUB MENU RENTAS VARIAS----------------------------
		REM ----------------------------------------------------------------------------
		:sub_menu_rentas_varias
		cls
		echo ==============================================================
		echo                             BIENVENIDO
		echo                  INFORMATICA Y TRIBUTOS - TEST CASE
		echo                        Hecho por equipo de QA
		echo                    %DATE% ^| %TIME%
		echo.
		echo ==============================================================
		echo                      Sub Menú Rentas Varias
		echo ==============================================================
		echo 1. Gestión Rentas Varias
		echo 2. Ir Al Menú Generación Del Tributo
		echo 0. Salir
		echo ==============================================================
		set /p option=Por favor seleccione una opcion:

		REM Validación de entrada
		if "%option%"=="1" goto gestion_rentas
		if "%option%"=="2" goto menu_generacion_del_tributo
		if "%option%"=="0" goto :EOF

		echo Opción no válida. Por favor, seleccione una opción válida.
		pause
		goto menu_principal
		
			REM ----------------------------------------------------------------------------
			REM -------------------------1.GESTION RENTAS-------------------------------------
			REM ----------------------------------------------------------------------------

			:gestion_rentas
			REM Codigo - ruta para la gestión de rentas
			set project_dir=C:\SMART_AUTOMATIZACION\SmartValleduparLiquidarRentas

			REM Ruta al archivo build.gradle
			set build_file=%project_dir%\build.gradle

			REM Verificar si el directorio del proyecto existe
			if not exist %project_dir% (
			  echo Directorio del proyecto no encontrado.
			  pause
			  goto menu_principal
			)

			REM Verificar si el archivo build.gradle existe
			if not exist %build_file% (
			  echo El archivo build.gradle no encontrado.
			  pause
			  goto menu_principal
			)

			REM Ejecutar Gradle para compilar el proyecto
			cd /d %project_dir%
			REM gradle clean build
			gradle clean build --warning-mode all

			REM Ruta al archivo de definición de características de Cucumber
			set feature_file=%project_dir%\src\test\resources\features\Smart.feature

			REM Ejecutar la prueba Cucumber
			cd /d %project_dir%
			gradle cucumber -PcucumberFeatures="%feature_file%"

			REM Esperar a que el usuario presione una tecla antes de regresar al menú principal
			pause
			goto menu_principal

			REM ----------------------------------------------------------------------------
			REM -------------------------FIN 1.GESTION DE RENTAS-----------------------------
			REM ----------------------------------------------------------------------------

		REM ----------------------------------------------------------------------------
		REM -------------------------FIN GENERACION DEL TRIBUTO-------------------------------
		REM ----------------------------------------------------------------------------

		REM ----------------------------------------------------------------------------
		REM --------------------------MENU GESTION FINANCIERA---------------------------
		REM ----------------------------------------------------------------------------
		:menu_gestion_financiera
		cls
		echo ==============================================================
		echo                             BIENVENIDO
		echo                  INFORMATICA Y TRIBUTOS - TEST CASE
		echo                        Hecho por equipo de QA
		echo                    %DATE% ^| %TIME%
		echo.
		echo ==============================================================
		echo                     Menú Gestión Financiera
		echo ==============================================================
		echo 1. Consulta General
		echo 2. Documentos
		echo 3. Recaudos
		echo 4. Ir Al Menú Principal
		echo 0. Salir
		echo ==============================================================
		set /p option=Por favor seleccione una opcion:

		REM Validación de entrada
		if "%option%"=="1" goto consulta_general
		if "%option%"=="2" goto sub_menu_documentos
		if "%option%"=="3" goto sub_menu_recaudos
		if "%option%"=="4" goto menu_principal
		if "%option%"=="0" goto :EOF

		echo Opción no válida. Por favor, seleccione una opción válida.
		pause
		goto menu_principal
		
			REM ----------------------------------------------------------------------------
			REM -------------------------CONSULTA GENERAL-------------------------------
			REM ----------------------------------------------------------------------------
			:consulta_general
			REM Coloca aquí el código para la consulta general
			set project_dir=C:\SMART_AUTOMATIZACION\SmartValleduparConsultaGeneral

			REM Ruta al archivo build.gradle
			set build_file=%project_dir%\build.gradle

			REM Verificar si el directorio del proyecto existe
			if not exist %project_dir% (
			  echo Directorio del proyecto no encontrado.
			  pause
			  goto menu_principal
			)

			REM Verificar si el archivo build.gradle existe
			if not exist %build_file% (
			  echo El archivo build.gradle no encontrado.
			  pause
			  goto menu_principal
			)

			REM Ejecutar Gradle para compilar el proyecto
			cd /d %project_dir%
			REM gradle clean build
			gradle clean build --warning-mode all

			REM Ruta al archivo de definición de características de Cucumber
			set feature_file=%project_dir%\src\test\resources\features\Smart.feature

			REM Ejecutar la prueba Cucumber
			cd /d %project_dir%
			gradle cucumber -PcucumberFeatures="%feature_file%"

			REM Esperar a que el usuario presione una tecla antes de regresar al menú principal
			pause
			goto menu_principal

			REM ----------------------------------------------------------------------------
			REM -------------------------FIN CONSULTA GENERAL-------------------------------
			REM ----------------------------------------------------------------------------
			
			REM ----------------------------------------------------------------------------
			REM --------------------------SUB MENU DOCUMENTOS---------------------------
			REM ----------------------------------------------------------------------------
			:sub_menu_documentos
			cls
			echo ==============================================================
			echo                             BIENVENIDO
			echo                  INFORMATICA Y TRIBUTOS - TEST CASE
			echo                        Hecho por equipo de QA
			echo                    %DATE% ^| %TIME%
			echo.
			echo ==============================================================
			echo                         Sub Menu Documentos
			echo ==============================================================
			echo 1. Emisión De Recibos Puntuales
			echo 2. Ir Al Menú Gestión Financiera
			echo 0. Salir
			echo ==============================================================
			set /p option=Por favor seleccione una opción:

			REM Validación de entrada
			if "%option%"=="1" goto emision_recibos_puntuales
			if "%option%"=="2" goto menu_gestion_financiera
			if "%option%"=="0" goto :EOF

			echo Opción no válida. Por favor, seleccione una opción válida.
			pause
			goto menu_gestion_financiera
			
			REM ----------------------------------------------------------------------------
			REM --------------------------FIN SUB MENU DOCUMENTOS---------------------------
			REM ----------------------------------------------------------------------------
			
			REM ----------------------------------------------------------------------------
			REM --------------------------SUB MENU RECAUDOS---------------------------
			REM ----------------------------------------------------------------------------
			:sub_menu_recaudos
			cls
			echo ==============================================================
			echo                             BIENVENIDO
			echo                  INFORMATICA Y TRIBUTOS - TEST CASE
			echo                        Hecho por equipo de QA
			echo                    %DATE% ^| %TIME%
			echo.
			echo ==============================================================
			echo                       Sub Menú Recaudos
			echo ==============================================================
			echo 1. Gestión Registro De Recaudo Manual
			echo 2. Ir Al Menú Gestión Financiera
			echo 0. Salir
			echo ==============================================================
			set /p option=Por favor seleccione una opción:

			REM Validación de entrada
			if "%option%"=="1" goto recaudos_manual
			if "%option%"=="2" goto menu_gestion_financiera
			if "%option%"=="0" goto :EOF

			echo Opción no válida. Por favor, seleccione una opción válida.
			pause
			goto menu_gestion_financiera
			
				REM ----------------------------------------------------------------------------
				REM ------------------------- RECAUDO MANUAL -----------------------------------
				REM ----------------------------------------------------------------------------

				:recaudos_manual
				REM Codigo - ruta para la gestión de rentas
				set project_dir=C:\SMART_AUTOMATIZACION\SmartValleduparRecaudosManual

				REM Ruta al archivo build.gradle
				set build_file=%project_dir%\build.gradle

				REM Verificar si el directorio del proyecto existe
				if not exist %project_dir% (
				  echo Directorio del proyecto no encontrado.
				  pause
				  goto menu_principal
				)

				REM Verificar si el archivo build.gradle existe
				if not exist %build_file% (
				  echo El archivo build.gradle no encontrado.
				  pause
				  goto menu_principal
				)

				REM Ejecutar Gradle para compilar el proyecto
				cd /d %project_dir%
				REM gradle clean build
				gradle clean build --warning-mode all

				REM Ruta al archivo de definición de características de Cucumber
				set feature_file=%project_dir%\src\test\resources\features\Smart.feature

				REM Ejecutar la prueba Cucumber
				cd /d %project_dir%
				gradle cucumber -PcucumberFeatures="%feature_file%"

				REM Esperar a que el usuario presione una tecla antes de regresar al menú principal
				pause
				goto menu_principal

				REM ----------------------------------------------------------------------------
				REM -------------------------FIN RECAUDO MANUAL---------------------------------
				REM ----------------------------------------------------------------------------
			
			REM ----------------------------------------------------------------------------
			REM --------------------------FIN SUB MENU RECAUDOS---------------------------
			REM ----------------------------------------------------------------------------
			
			REM ----------------------------------------------------------------------------
			REM -------------------------EMISION DE RECIBO-------------------------------
			REM ----------------------------------------------------------------------------
			:emision_recibos_puntuales
			REM Coloca aquí el código para la consulta general
			set project_dir=C:\SMART_AUTOMATIZACION\SmartValleduparEmisionDeRecibos

			REM Ruta al archivo build.gradle
			set build_file=%project_dir%\build.gradle

			REM Verificar si el directorio del proyecto existe
			if not exist %project_dir% (
			  echo Directorio del proyecto no encontrado.
			  pause
			  goto menu_principal
			)

			REM Verificar si el archivo build.gradle existe
			if not exist %build_file% (
			  echo El archivo build.gradle no encontrado.
			  pause
			  goto menu_principal
			)

			REM Ejecutar Gradle para compilar el proyecto
			cd /d %project_dir%
			REM gradle clean build
			gradle clean build --warning-mode all

			REM Ruta al archivo de definición de características de Cucumber
			set feature_file=%project_dir%\src\test\resources\features\Smart.feature

			REM Ejecutar la prueba Cucumber
			cd /d %project_dir%
			gradle cucumber -PcucumberFeatures="%feature_file%"

			REM Esperar a que el usuario presione una tecla antes de regresar al menú principal
			pause
			goto menu_principal

			REM ----------------------------------------------------------------------------
			REM -------------------------FIN EMISION DE RECIBOS-----------------------------
			REM ----------------------------------------------------------------------------

		REM ----------------------------------------------------------------------------
		REM -------------------------FIN GESTION FINANCIERA-----------------------------
		REM ----------------------------------------------------------------------------

	REM ----------------------------------------------------------------------------
	REM -------------------------MENU PQR-------------------------------------
	REM ----------------------------------------------------------------------------

		REM ----------------------------------------------------------------------------
		REM --------------------------SUB MENU PQR---------------------------
		REM ----------------------------------------------------------------------------
		:menu_pqr
		cls
		echo ==============================================================
		echo                             BIENVENIDO
		echo                  INFORMATICA Y TRIBUTOS - TEST CASE
		echo                        Hecho por equipo de QA
		echo                    %DATE% ^| %TIME%
		echo.
		echo ==============================================================
		echo                        	  Menú PQR
		echo ==============================================================
		echo 1. Nuevo PQR
		echo 2. Ir Al Menú Principal
		echo 0. Salir
		echo ==============================================================
		set /p option=Por favor seleccione una opción:

		REM Validación de entrada
		if "%option%"=="1" goto nuevo_pqr
		if "%option%"=="2" goto menu_principal
		if "%option%"=="0" goto :EOF

		echo Opción no válida. Por favor, seleccione una opción válida.
		pause
		goto menu_principal

			:nuevo_pqr
			REM Codigo - ruta PQR
			set project_dir=C:\SMART_AUTOMATIZACION\SmartValleduparPQR

			REM Ruta al archivo build.gradle
			set build_file=%project_dir%\build.gradle

			REM Verificar si el directorio del proyecto existe
			if not exist %project_dir% (
			  echo Directorio del proyecto no encontrado.
			  pause
			  goto menu_principal
			)

			REM Verificar si el archivo build.gradle existe
			if not exist %build_file% (
			  echo El archivo build.gradle no encontrado.
			  pause
			  goto menu_principal
			)

			REM Ejecutar Gradle para compilar el proyecto
			cd /d %project_dir%
			REM gradle clean build
			gradle clean build --warning-mode all

			REM Ruta al archivo de definición de características de Cucumber
			set feature_file=%project_dir%\src\test\resources\features\Smart.feature

			REM Ejecutar la prueba Cucumber
			cd /d %project_dir%
			gradle cucumber -PcucumberFeatures="%feature_file%"

			REM Esperar a que el usuario presione una tecla antes de regresar al menú principal
			pause
goto menu_principal

REM ----------------------------------------------------------------------------
REM ------------------------------FIN MENU PRINCIPAL----------------------------------
REM ----------------------------------------------------------------------------

:EOF
