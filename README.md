# ResumeApp
### Description
An interactive app containing my resume.
### Features.
 - Open social media links from the application using [Implicit Intents](https://developer.android.com/guide/components/intents-filters).
 - Use dark and light theme [Material 3](https://m3.material.io/) on the application.
 
### Wishlist Features
- Splash Screen
### Challenges Faced
Enabling the email intent. At first, I had not added the `Intent.putExtra` which made the `mailIntent` not work. After researching, I got the correct method of doing it.
```val mailIntent = Intent(Intent.ACTION_SEND)
   val emailAddress = arrayOf(GMAIL_LINK)
   mailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress
   mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application"
   mailIntent.putExtra(
   Intent.EXTRA_TEXT,
   "Hello Joy, I hope this finds you well."
   )
   mailIntent.type = "message/rfc822"
   context.startActivity(Intent.createChooser(mailIntent, "Sending Email from this app")
   )
   ```
### Application APK(Appetize)
[Apk](https://appetize.io/app/2cez72krgeexugn32q6jp6a4uy?device=pixel4&osVersion=11.0&scale=75)

