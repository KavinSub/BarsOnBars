# Makefile for Bars On Bars project

# Makefile variable for java compiler
JCC = javac

BarsOnBars: MainDisplay.class BarPanel.class Bar.class
	jar cfm BarsOnBars.jar Manifest.txt MainDisplay.class BarPanel.class Bar.class
	chmod 700 BarsOnBars.jar

MainDisplay.class: MainDisplay.java
	$(JCC) MainDisplay.java

BarPanel.class: BarPanel.java
	$(JCC) BarPanel.java

Bar.class: Bar.java
	$(JCC) Bar.java

clean:
	rm *.class
	rm BarsOnBars.jar