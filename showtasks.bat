call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startchrome
echo.
echo Calling runcrud failed - breaking work
goto fail

:startchrome
start chrome.exe
goto end

:fail
echo Errors occured

:end
echo Showtasks work is finished.