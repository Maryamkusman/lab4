# Lab Report 3:  

written by Shuyi Han(PID: A16470709) on Feb 11th 2022
 

## Streamlining ssh Configuration

"SSH, like many programs, has configuration files that can save you some typing" -- CSE15L Week 5

**Part 1. Creating a SSH Config File and Editing on it**

![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-02-11%20at%206.12.29%20PM.png)
To create a SSH config file, I click on **Finder**, choose **Go** on the top left of the screen, then click on **Go to Folder**, then type in "**~/.ssh/**". The
**.ssh** folder contains the **private key (in a file id_rsa)** and the **public key (in a file id_rsa.pub)**, and a file called **known_hosts** stored in the .ssh directory on my computer. I create a file called **config** by using **TextEdit** application in Mac. 



To streamline ssh configuration, I add the given lines in lab

```
Host ieng6
    HostName ieng6.ucsd.edu
    User cs15lwi22zzz (use your username)
```



Then, modifying the lines by changing the nickname and username
```
Host cs15l (the nickname given by me)
    HostName ieng6.ucsd.edu
    User cs15lwi22aes (my username)
```






**Part 2. Working with ssh After Streamlining it**

![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-02-11%20at%206.27.02%20PM.png)
After streamlining my ssh, I am able to use the alias that I created in the previous step to log me into my server account without specify my actual account name





![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-02-11%20at%206.14.02%20PM.png)
I use "**ls**" to see what files are in my account



To copy a file to my account using just the alias I chose, I choose **"MarkdownParse.java"**, and type "**scp MarkdownParse.java cs15l:~/**" 
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-02-11%20at%206.27.02%20PM.png)
It works because after the command, my server account contains one more file called **"MarkdownParse.java"**



