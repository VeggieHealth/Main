# VeggieHealth Flask API

## Description

VeggieHealth Flask API is a RESTful API built with Flask, primarily designed to run a Machine Learning model capable of detecting various types of vegetables. This API provides a single endpoint for making predictions about the type of vegetable detected based on the provided input data.

## Usage

### Endpoint

- **Predict Vegetable Type**: Use the `/predict` endpoint to submit data and receive predictions about the detected vegetable type.

### Request Format

- **HTTP Method**: POST
- **Endpoint**: `/predict`
- **Request Body**: Form Data with a key named "file" containing the file data.

Example Request (using cURL):

```bash
curl -X POST -F "file=@/path/to/your/file" https://flask-app-veggie-df3dj4kgla-et.a.run.app/predict
```

# Response Format

The API will respond with JSON data containing the prediction results.

Example Response:

```json
{
  "accuracy": 98.91195297241211,
  "prediction": "Brinjal",
  "status": true,
  "vegetableId": 4
}
```

# Getting Started

To use the VeggieHealth Flask API for vegetable detection:

1. **Send POST Request**: Use the `https://flask-app-veggie-df3dj4kgla-et.a.run.app/predict` endpoint with the file attached as form data.
2. **Receive Response**: Retrieve the predicted vegetable type from the JSON response.

## How to Contribute

If you're interested in contributing to VeggieHealth Flask API, you can:

- **Report Issues**: Help by reporting bugs or issues through GitHub Issues.
- **Enhancements**: Contribute improvements to enhance the API's functionality.
- **Pull Requests**: Submit pull requests following the contribution guidelines outlined in CONTRIBUTING.md.

## Support and Contact

For any questions, concerns, or support regarding VeggieHealth Flask API, feel free to reach out via email or through GitHub issues.

Your contribution and support in improving the VeggieHealth Flask API for accurate vegetable detection are greatly appreciated.

Happy coding and healthy eating! 🥦🥕🍅
