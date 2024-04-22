# Define colors
debian_blue = "\033[34m"  # Light blue for Debian
python_yellow = "\033[33m"  # Yellow for Python

# Define Debian Bookworm logo (replace with actual logo if desired)
debian_logo = """
         _.--""--._
       .'        `.
      /   .--""--.   \
     |  .'        `.  |
     | |  .--""--.  | |
     | | |        | | |
     |_| '--""--' |_|
       `--------`

"""

# Define Python logo with color escape sequences
python_logo = f"""
{python_yellow}   _______    _______  _______  _______ 
  / ____\   |  __ \  |   _   \ |       |
 | (___  \  | |__) | |  |\  \| |____  |
  \___ \ | |  _  /  |  |\  \  |       |
  ____) \| | | \ \  |  |\  \ | |_____ |
 | |_____/  | |  |\ | _| \_\ |_______|
 |          |_|  |_\|_____|          
{debian_blue}"""

# Print logos with color
print(debian_logo)
print(python_logo)

# Reset color after logos
print("\033[0m")  # Reset to default color
