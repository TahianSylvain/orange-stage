#!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Use a production WSGI server instead.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
import numpy as np
import keras, json, subprocess, pyfiglet, requests
from flask import Flask, jsonify, request
from flask_cors import CORS, cross_origin

app = Flask(__name__)
CORS(app,
    resources={
        r"/predict": {
            "origins": ["http://localhost:9090", "http://localhost:5173"] #quarkus react
        }
    }
)


@cross_origin()
@app.route('/predict', methods=['POST'])
def predict() -> json:
    try:
        data = request.get_json()
        if not isinstance(data, dict) or 'data' not in data:
            return jsonify({'error': 'Invalid data format'}), 400

        prices = [float(p) for p in data['data']]
        model = keras.saving.load_model( "./my_model.keras")
        predictions = model.predict(np.array(prices).reshape(-1, 15))
        print({"predictions": {
            "cost": '$' + str(round(abs(predictions.tolist()[0][2]) + 20, 1)),
            "quality": str(round(abs(predictions.tolist()[0][1]) + 2, 1)) + "/5",
            "nb_customer": round(abs(predictions.tolist()[0][0]), 0)
        }}, end="\n\n")

        return jsonify({'predictions': predictions.tolist()})

    except Exception as e:
        return jsonify({'error': str(e)}), 500


if __name__ == '__main__':# Command to execute
    command = "neofetch"
    output = subprocess.check_output(command, shell=True)
    output = output.decode("utf-8")

    #Get Python logo ASCII art blue color
    python_logo = pyfiglet.figlet_format("Python-3.10.2")
    print(output + "\n" + "\033[1;34m" + python_logo + "\033[0m")

    app.run(debug=True , host='0.0.0.0', port=8080)
