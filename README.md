# Android Contacts Permission Demo

A Kotlin-based Android application that demonstrates how to handle runtime permissions for accessing device contacts. This project showcases proper permission requesting, handling user responses, and displaying appropriate UI based on permission status.

## **Features**

- Requests **`READ_CONTACTS`** permission at runtime
- Displays real device contacts when permission is granted
- Shows dummy contact data when permission is denied
- Implements proper permission handling following Android best practices
- Clean and intuitive user interface

## **Screenshots**

### **Permission Request**

![https://permission_request.jpg]([https://permission_request.jpg/](https://github.com/S30ULFR05T/read_contact_dispaly_name/blob/a5111492ac55cbddb706781416e98a7e7e6ea4f4/contact%201.jpg))

When the app launches, it requests the **`READ_CONTACTS`** permission necessary to access your device's contact list.

### **Contacts List (Permission Granted)**

![https://contacts_allowed.jpg]([https://contacts_allowed.jpg/](https://github.com/S30ULFR05T/read_contact_dispaly_name/blob/a5111492ac55cbddb706781416e98a7e7e6ea4f4/contact%202.jpg))

If you grant the permission, the app displays your actual device contacts in a scrollable list.

### **Dummy Contacts (Permission Denied)**

![https://contacts_denied.jpg]([https://contacts_denied.jpg/](https://github.com/S30ULFR05T/read_contact_dispaly_name/blob/a5111492ac55cbddb706781416e98a7e7e6ea4f4/contact%203.jpg))

If you deny the permission, the app shows a list of dummy contacts instead of your real ones.

## **Implementation Details**

This project demonstrates:

1. **Runtime Permission Handling**: Using **`ActivityResultContracts.RequestPermission()`** to request contacts permission
2. **Permission Status Checking**: Verifying if a permission has been granted before accessing sensitive data
3. **ContentResolver Usage**: Querying the device's contacts database using Android's Content Provider system
4. **RecyclerView Implementation**: Displaying contacts in a scrollable list with a custom adapter
5. **Error Handling**: Gracefully handling permission denial with fallback data

## **Technical Stack**

- Kotlin
- Android Studio
- AndroidX Libraries
- Activity Result API
- ContentResolver for contacts access
- RecyclerView for list display

## **Project Structure**

text

```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/
│   └── com.example.layout_practice_2/
│       ├── ui.theme/
│       ├── MainActivity.kt
│       └── (other Kotlin files)
└── res/
    ├── drawable/
    ├── layout/
    │   ├── activity_main.xml
    │   └── contact_list_item.xml
    ├── mipmap/
    ├── values/
    └── xml/
```

## **Getting Started**

### **Prerequisites**

- Android Studio (latest version)
- Android device or emulator with API level 23+

### **Installation**

1. Clone this repository
2. Open the project in Android Studio
3. Build and run the application on your device or emulator

## **Usage**

1. Launch the app
2. Grant or deny the contacts permission when prompted
3. View either your real contacts (if permission granted) or sample contacts (if denied)
4. To test both flows, you can reset app permissions in your device settings

## **Code Highlights**

The main functionality centers around requesting and handling the contacts permission, then displaying appropriate content based on the user's choice.

## **License**

This project is open source and available under the MIT License.
