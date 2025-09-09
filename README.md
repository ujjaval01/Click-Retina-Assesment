# User Profile App (Assignment)

This is an Android assignment project built using **Kotlin**.  
The app displays user profile information by fetching data from a static **JSON file** and rendering it in a clean UI.

---

## 🚀 Features
- Splash screen with loader  
- Display user details (name, username, location, avatar)  
- Show followers & following counts  
- Show activity stats (shots & collections)  
- Social media integration:
  - Website (from JSON)
  - Instagram (from JSON)
  - Facebook
  - Twitter
  - GitHub (hardcoded link)  
- Responsive UI with **Lottie animations** and **Material Design**  

---

## 🛠️ Tech Stack
- **Language:** Kotlin  
- **UI:** XML Layouts, Material Components  
- **Animations:** Lottie  
- **Architecture:** MVVM (ViewModel + LiveData)  
- **Image Loading:** Glide  

---

## 📂 Project Structure
app/
├── data/
│ └── model/ # Data models (User, Social, Stats, etc.)
├── ui/
│ ├── MainActivity.kt
│ ├── SplashActivity.kt
│ └── viewmodel/ # UserViewModel
├── res/
│ ├── layout/ # App layouts
│ ├── drawable/ # Backgrounds & icons
│ └── raw/ # Lottie JSON animations

---

## ⚡ Setup & Run
1. Clone the project:
   ```bash
   git clone https://github.com/ujjaval01/Click-Retina-Assesment.git
Open in Android Studio

Sync Gradle

Run the app on an emulator or real device

Apk Link:-  https://drive.google.com/file/d/1ECxnZYioW1OseNbCuPT5KG2rfQQ54kLW/view?usp=drive_link

🎯 Notes
JSON data is stored locally in the project.

Only the Website and Instagram links are dynamic (from JSON).

GitHub link is hardcoded for demo purposes.

📜 License
This project was created as part of an assignment task.
