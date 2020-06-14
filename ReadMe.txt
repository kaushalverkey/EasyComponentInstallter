Its a Java project and having AppStarter.java which is the main class to start the project.

when you run this file as Java application from the eclipse or any other Java IDE

and at console provide the command line input as 

DEPEND TELNET TCPIP NETCARD
DEPEND TCPIP NETCARD
DEPEND DNS TCPIP NETCARD
DEPEND BROWSER TCPIP HTML
INSTALL NETCARD
INSTALL TELNET
INSTALL foo
REMOVE NETCARD
INSTALL BROWSER
INSTALL DNS
LIST
REMOVE TELNET
REMOVE NETCARD
REMOVE DNS
REMOVE NETCARD
INSTALL NETCARD
REMOVE TCPIP
REMOVE BROWSER
REMOVE TCPIP
END


will result O/P

Installing TELNET
Installing TCPIP
Installing NETCARD
[DEPEND, TCPIP, NETCARD]
TCPIP is already installed
NETCARD is already installed
[DEPEND, DNS, TCPIP, NETCARD]
Installing DNS
TCPIP is already installed
NETCARD is already installed
[DEPEND, BROWSER, TCPIP, HTML]
Installing BROWSER
TCPIP is already installed
Installing HTML
[INSTALL, NETCARD]
INSTALLNETCARD
[INSTALL, TELNET]
INSTALLTCPIP
INSTALLTELNET
[INSTALL, foo]
Package is not configured: foo
[REMOVE, NETCARD]
REMOVENETCARD
[INSTALL, BROWSER]
INSTALLHTML
INSTALLBROWSER
[INSTALL, DNS]
INSTALLNETCARD
INSTALLDNS
[LIST]
Package: BROWSER, *
- Dependencies: 
, TCPIP
, HTML
Package: TELNET, *
- Dependencies: 
, TCPIP
, NETCARD
Package: TCPIP, 
- Dependencies: 
Package: DNS, *
- Dependencies: 
, TCPIP
, NETCARD
Package: HTML, 
- Dependencies: 
Package: NETCARD, 
- Dependencies: 
[REMOVE, TELNET]
REMOVETELNET
REMOVETCPIP
REMOVENETCARD
[REMOVE, NETCARD]
NETCARD is not installed
[REMOVE, DNS]
REMOVEDNS
[REMOVE, NETCARD]
NETCARD is not installed
[INSTALL, NETCARD]
INSTALLNETCARD
[REMOVE, TCPIP]
TCPIP is not installed
[REMOVE, BROWSER]
REMOVEBROWSER
REMOVEHTML
[REMOVE, TCPIP]
TCPIP is not installed
