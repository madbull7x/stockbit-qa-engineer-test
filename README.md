# Stockbit QA Engineer Test

## Android
1. File Android Automation Test ada di directory android_test
2. Video running

https://user-images.githubusercontent.com/61624268/202856241-6e485dbc-28bd-4dc1-9e4d-0a5b4d86fd9f.mp4


#### Tools:    
* Android Studio (sudah terinstall)  
* InteliJ + Java JDK (sudah terinstall)  
* NodeJS + Appium (sudah terinstall)  
* Appium Inspector (sudah terinstall)   
* Git (sudah terinstall)  
#### Steps:
* pastikan semua environment variable yang dibutuhkan seperti JAVA_HOME, ADB, emulator sudah berjalan  
* Download & run apk yang akan di automasi, ambil info yang dibutuhkan dalam desire capability nantinya, spt: packageName & activityName  
* Uji desired cabability menggunakan Appium Inspector.  
* setelah berjalan lancar, lanjutkan develop automation script sesuai scenario.  


## API
1. File API test ada di directory api_test
2. Video running

https://user-images.githubusercontent.com/61624268/202856256-4e82af8a-b812-4b81-96c0-ed5c9dac1ac4.mp4


#### Tools:
* VsCode

#### Steps:
* NodeJS (sudah terinstall)
* Inisiasi node project
    ```sh
    npm init -y
    ```

* install package yg dibutuhkan
    ```sh
    npm i mocha --save-dev
    npm i chai --save-dev
    npm i chai-http --save-dev
    npm i chai --save-dev
    npm i chai-json-schema --save-dev
    npm i mochawesome --save-dev
    ```

* untuk memudahkan eksekusi, tambahkan script test dalam package.json
    ```sh
    "scripts": {
        "test": "mocha --reporter mochawesome"
    },
    ```

* develop script sesuai scenario


