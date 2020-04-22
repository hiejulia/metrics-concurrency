<a href="https://imgur.com/Ef2ChBc"><img src="https://i.imgur.com/Ef2ChBc.png" title="source: imgur.com" /></a>


- import java.rmi.server.*;

- String url = "rmi://127.0.0.1/max2ser";
imax2 mi =(imax2)Naming.lookup(url);



- run application 
    - generate stub and skeletons with RMI compiler 
        - rmic Max2Class 
    - start RMI registry : start rmiregistry
    - Running server and client 
    