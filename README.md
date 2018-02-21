# morsecode

Tiny Java project to convert text to morse and morse to text. Very simple, quick project, do with it what you want.

## Command Line Arguments Usage

**-help** Outputs: 
```
Help and Usage
-seperator / -encrypt "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"
-seperator /-unencrypt "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --."
-replace / # "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --."
```

**-SEPERATOR** Replaces the default '/' seperator with your own if it's not following the common convention.
```
-SEPERATOR #
```

**-ENCRYPT** Encrypts plaintext using the 
```
-ENCRYPT "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"
```

**-UNENCRYPT** Unencrypts Morse that uses the '/' to denote spaces. If you wish to use a different seperator see the seperator tags.
```
-UNENCRYPT "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --."
```

**-REPLACE** Replaces the delimitter character with your own and outputs the still ciphered text with the new delimitter.

```
-REPLACE / # "- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --."
```
