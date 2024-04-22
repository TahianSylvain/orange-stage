import pyfiglet


#Get Python logo ASCII art
python_logo = pyfiglet.figlet_format("Python-3.10.2")

# Print Python logo ASCII art with color
print("\033[1;34m" + python_logo + "\033[0m")
