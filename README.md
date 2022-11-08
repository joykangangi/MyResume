# ResumeApp
### Description
An interactive app containing my resume. This is my Stage 2 Task at HNGi9 Internship.
### Features.
 - Display name 
 - Dispaly picture
 - About me and Skills
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
### Links
* [Appetize.io Link](https://appetize.io/app/2cez72krgeexugn32q6jp6a4uy?device=pixel4&osVersion=11.0&scale=75)
* [Google Drive Link with APK](https://drive.google.com/file/d/1jaW8i4_WnI0lNvsjEyRVkuilc26TMGM-/view?usp=sharing)
* [New Appetize Link](https://appetize.io/app/v3zzx3obd5zhgffup5tiwnzzya?device=pixel4&osVersion=11.0&scale=75)

### Screenshots 
#### 
<table>
  <tr>
      <td>Light Mode</td>
      <td>Dark Mode</td>
  </tr>      
  <tr>
      <td><img src="https://user-images.githubusercontent.com/64706463/200569054-6c4e6492-eae5-47ce-ab55-bb5ac33c6bf1.png" alt="light"></td>
      <td><img src="https://user-images.githubusercontent.com/64706463/200568692-c5b7fc56-c8fd-4bbd-9799-6f315f9593a4.png" alt="dark"></td>
  </tr> 
</table>
