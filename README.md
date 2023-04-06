# 2FA Example using Java/Spark and the Verify API

This is the source code to accompany the [Implementing Two-Factor Authentication (2FA) with Java and Spark blog post]()

* [Requirements](#requirements)
* [Installation and Usage](#installation-and-usage)
  * [API Credentials](#api-credentials)
  * [Running the Application](#running-the-application)
* [Contributing](#contributing)
* [License](#license)

## Requirements

This application requires that you have the following installed locally:

* IDE of your choice
* the latest version of Java 
* Gradle

Additionally, to test the application, you must have a Vonage account. You can create a Vonage account for free or manage your Vonage account details at the [Vonage Dashboard](https://developer.vonage.com).

## Installation and Usage
You can run this application by first cloning this repository locally and opening in your IDE. 

Once you have downloaded a local copy, change into the directory of the application and you can now set up the API credentials for your Vonage account.

### API Credentials

Inside the `Domain` folder, you'll see a file named `Configuration.cs`. Add your Vonage API key to the string values for `APIKey` and `APISecret`. 

As always, make sure not to commit your sensitive API credential data to any public version control. 

### Running the Application

1. Execute `gradle run` in your terminal.
2. Visit `http://localhost:3000` in your browser.
3. Enter your cell phone number with the international dialing code but omit the `+` symbol and any leading zeros.
4. Press the Register button. In a moment or two you should receive a verification code via SMS.
5. Enter the verification code and press Check.
6. If you have entered the code successfully, you should receive a message that reads "Registration successful". If not, you will receive a message that reads "Verification failed".

## Contributing

We ❤️ contributions from everyone! If you see something that needs fixing, then please follow the [GitHub Flow](https://guides.github.com/introduction/flow/index.html) and we'll try to incorporate it.

## License

This project is under the [Apache 2.0 License](https://github.com/Vonage-Community/blog-sms-csharp-realestate/blob/main/LICENSE).
