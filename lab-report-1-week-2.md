# Lab Report 1:  
## The Best Tutorial about Logging Into a Course-specific Account on ieng6
written by Shuyi Han(PID: A16470709) on Jan 12th 2022


## Overview 
The tutorial is going to walk you through every single step needed to log into a course-specific account on ieng6 and teach you some basic commands and concepts. No prior knowledge required! Let's get started!

**What you will learn**
* Installing VScode
* Remotely Connecting
* Trying Some Commands
* Moving Files with scp
* Setting an SSH Key
* Optimizing Remote Running

**What you Need**

A laptop with one of the major operating systems 


## Installing VScode
1. Click on [this link](https://code.visualstudio.com/)

2. This IDE has different versions built for all the major operating system.Select the one that fits you computer.
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-12%20at%2011.22.28%20PM.png)


3. Follow the tutorial to download and install VScode on your computer. After opening the window, you will see the screen looking like this.  
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-12%20at%2011.13.50%20PM.png)

## Remotely Connecting

Since there are always circumstances when you have to use or control remote servers intead of your own, some instutions give users specific account to get on certain systems. We will try to our own computer to a remote server in this step.

1. If you have a windows system, click on [this link](https://sdacs.ucsd.edu/~icc/index.php) and download. Since I have a Mac System, I did not do this step.
2. Then, find your own 15L's course-specific account using [this link](https://sdacs.ucsd.edu/~icc/index.php). You should change the password in order to log into the account.
3. Open a terminal in VScode by clicking on **Terminal** on the top left of the screen, and select **New Terminal** Type in `ssh cs15lwi22aes@ieng6.ucsd.edu ` with the aes be changed with some characters in your course account. Then, type in your password after the terminal shows `Password: `. It would take a few seconds for the client to conenct to the server. Example below shows no step of entering password since ssh key has been setup before (explained in later step).
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%2012.33.50%20AM.png)
4. In here, I typed `ssh cs15lwi22aes@ieng6.ucsd.edu ` and given my password. Now, my own computer, the client's terminal  gets connected with a computer, or the server, in CSE basedment.

## Type some commands 
1. Every line starting with `[cs15lwi22aes@ieng6-202]:~:` indicates I have logged in the ieng6 account, and that means any command I run on the computer will also run on the server.
2. To try some commands, I type the following commands. You are also encouraged to do so.
* cd ~
change directory to defualt or home directory
* cd
change directory
* ls -lat
* ls -a
listing all the files in the current folder and showing content of the current directory
* cp /home/linux/ieng6/cs15lwi22/public/hello.txt ~/
copy a file or a folder
* cat /home/linux/ieng6/cs15lwi22/public/hello.txt
create, view, concatenate file
3. After running all the commands, the screen should look like this
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%201.05.05%20AM.png)
4. If you want to run the command on your own computer instead of the remote sever. You should type in `exit`. The pitcure belows shows what the terminal looks like.

![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%201.35.45%20AM.png)


## Moving Files with scp

One way to move files back and forth between server and client, in other words, copy a file from my computer to the remote one is the command `scp`
1. To copy a file called `My2DList.class` to the remote computer, I typed `scp My2DList.class cs15lwi22aes@ieng6.ucsd.edu:~/` . scp stands for secure copy, followed by the file name, which followed by the course account name
2. To check if the command works, I log into ineg6 by command `ssh cs15lwi22aes@ieng6.ucsd.edu` and run `ls` to list all the file in the defualt direcotry. You can see that `My2DList.class` is there now. 
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%201.48.47%20AM.png)


## Setting An SSH Key

To avoid retyping password whenver we do a related task, we can use the `ssh` keys. The logic behind the command is a program named ssh-keygen makes two files, the public key on the server and private key on the client. `ssh` command benefits the pair of files rather than asking for the password input.
1. run the command `ssh-keygen`
2. After seeing the terminal showing `Enter file in which to save the key (/Users/xiaolong/.ssh/id_rsa):`, the file of private key has been created, copy the name of the file, or content in the prenthesis, and paste it as input.
3. Ignoring the requirements of input of `Enter passphrase (empty for no passphrase): `and `Enter same passphrase again: ` by hitting Enter key
4. As shown in the picture, the program has generated two new files on the system: the private key ended `id_rsa` and the public key ended with `id_rsa.pub`. Both of them are stored in the .ssh directory on client.
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%202.33.11%20AM.png)
5. Since the server needs the public key to pair with client' private key and automatically open the account, we have to copy the public key from the client to .ssh directory of the server's account. To do this using `scp` command followed by public key, which is followed by ineng6 account number and .ssh direcotry. Example of my commands is `scp /Users/xiaolong/.ssh/id_rsa.pub cs15lwi22aes@ieng6.ucsd.edu:~/.ssh/authorized_keys`
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%202.53.01%20AM.png)
6. As showing in the picture, after the previous commands, I do not have to enter password for doing `ssh` and `scp` from my laptop to the remote computer 
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%202.53.39%20AM.png)
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%202.55.26%20AM.png)

## Optimizing Remote Running

To make running commands even easier and faster, I can give you three hints given 

* hit the up-arrowkey on the keyboard to retrieve the previous commands if needed. 
* Since semicolons in coding environment means the end of a command's excecution,if you want to type more than one command on the same line, seperating them by semicolons. Example is given in the picture below.
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%203.14.59%20AM.png)
This will save you one key stroke than typing java WhereAmI on a separate line.

* A quick way to stay as the client while still running a command on a remote computer is using ssh command followed by a command in quotes.Notice in the picture, after running the command, the location of terminal is still `xiaolongdeMBP:Downloads xiaolong$`.
![Image](https://github.com/KristinShuyiHan/cse15l-lab-reports/blob/main/Screen%20Shot%202022-01-13%20at%203.16.19%20AM.png)
* Behind this command, the computer acutally log in to the remote server(1), compile (2)and run WhereAmI.java (3), then exit the remote server(4). As a result, this single commond saves you two key strokes than giving "javac WhereAmI.java" and "exit"command on two seperate lines, semicolons save you one keystroke of giving "java WhereAmI" on a seperate line. These two shortcuts combined together to save you three keystorkes. One thing to note is this pleasant process requires SSH key being properly setup, otherwise, you would have to enter the password when connecting to the remote server. 
---
**After reading this, I believe you are going to be more comfortable by the next time when dealing with operations relating to communication between client and account on remote server.** 

