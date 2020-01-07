## Opbot (in Scala)

## Building
1. The build tool is Mill (http://www.lihaoyi.com/mill/index.html), so it needs to be installed. Alternatively, using VS Code with the Scala Metals extension should work too.
2. Once mill is installed, then from the project's `scala/` directory run the command `mill -i opbotcore.repl` and this will bring up an Ammonite scala REPL withe the build dependencies in scope.
3. If there is code in a worksheet that you want to play with, then you must import it into the repl using ``import $file.opbotcore.src`<worksheetname>.worksheet.sc`` (yes, with the back ticks), and then follow it with ``import `<worksheetname.worksheet>`._` Very confusing yes!