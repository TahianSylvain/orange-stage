# Use the official Python 3.10 image as base DEBIAN.11
FROM python:3.10.2-slim-bullseye

# Define an argument for Python environment
ARG PYTHON_ENV=my_env

# Set the Python environment variable
ENV PYTHON_ENV=$PYTHON_ENV

# # Create a directory for storing requirements
RUN mkdir /requirements

COPY ./api.py /app/api.py
COPY ./my_model.keras /model/my_model.keras

# # Copy the requirements.txt and set_python_env.sh script into the container
COPY ./requirements.txt ./set_python_env.sh /requirements/

# # Run the set_python_env.sh script to set up the Python environment
RUN bash /requirements/set_python_env.sh $PYTHON_ENV

# Set the working directory to /app
WORKDIR /app

# Copy the Python code into the container
COPY . /app/

# Install libs
# RUN pip install keras Flask jsonify

# Expose port 8080 for Flask app
EXPOSE 8080

# Command to run the Flask application
CMD ["python", "api.py"]
