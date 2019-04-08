lab6 and lab7

1. get Animation4Thread running:

    rewrite main.java and Animation4Thread.java

2. implement it into the rest of our code.

3. add a JButton that toggles the orc movement when you press it:

    expand the frame to have space for the button
    
    make the button which toggles a bool
    
    if the bool is true (orc is stopped), don't run [x,y]loc += [x,y]Vel in Model.java
4. implement key presses
	
	keylistener and actionlistner should be in controller
		should be implemented in keyPressed
		Parameter: KeyEvent e - e.getKeyCode()