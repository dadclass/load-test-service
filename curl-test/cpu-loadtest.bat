@echo off

if [%1] == [] goto NO_INPUT

for /l %%x in (1, 1, %1) do (
   start /b curl -w "\n" http://localhost:8080/loadcpu?request=%%x
   echo request#%%x sent at %time%
)
echo %1 requests are sent ...
goto EXIT

:NO_INPUT
	echo usage: cpu-loadtest.bat 3  (pass in number of requests to be sent and try again)
:EXIT
