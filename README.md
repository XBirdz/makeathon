
# Sunseeker

App to find destinations based on the preferred activity and weather predictions using GPT4 and Weather API. 

# # Tech Stack 🛠️

JavaFX: Utilized for the graphical user interface.

Vanilla Java: Core language for the application logic.



## Features 🌟
Background Images: The app starts with captivating background images fetched from the Unsplash API to create an immersive experience.
Multistep Form:
- Users select preferred activities.
- Users choose their desired weather conditions.
- Users select accommodation type.
- Users input location, check-in and check-out dates, travel distance preference - (nearby, inside the country, outside the country, overseas), budget, and company type - (solo, family, friends, etc.).
- GPT Model Integration:
    * Using a GPT model, the app generates a list of top destinations based on the user's - selections.
- Open Meteo API Integration:
    * The app makes an API call to Open Meteo to validate that the weather for the next 10 days - matches the user's criteria for the selected destinations.
- Top 3 Destinations:
    * After processing the user input and weather validation, the app presents the top 3 recommended destinations to the user.


## Installation 🚀

1. Clone the repository:
    git clone https://github.com/XBirdz/makeathon.git

2. Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).
3. Run the Main.java file to launch the application.

    
## Usage 🌍

1. Upon launching, the app displays background images fetched from Unsplash.
2. Follow the multistep form to input your preferences:
   * Select activities.
   * Choose weather preferences.
   * Specify accommodation type.
   * Provide location, dates, travel distance, budget, and company type.
   * Click "Submit" to generate top destination suggestions.
3. The app will display the top 3 destinations along with relevant information and weather validation for the next 10 days.

