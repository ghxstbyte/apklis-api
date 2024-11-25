## ApklisApi v3

Esta librería ayuda a obtener la información de las aplicaciones desde la tienda de aplicaciones cubana  [Apklis](https://www.apklis.cu) compatible con la Api v3.


### Add Dependency in Gradle

```kotlin
implementation("com.github.ghxstbyte:apklis-api:1.0.0")
```

### Usage
```groovy
ApklisTool api = new ApklisTool.Builder().build();
api.hasUpdate(this, new UpdateCallback() {
  @Override
   public void lastRelease(LastRelease response) {
   // obtener la información necesaria 
     }
     @Override
      public void onError(Throwable e) {
      // captura el error 
       }
  });
                
```

### Samples 

Se ha creado un pequeño ejemplo de como funciona la librería. [Código de ejemplo](app/src/main/java/com/arr/apklisexample/MainActivity.java)

### Licence
> Apache License
>
> Copyright [2024] [Alessandro Rodríguez]
>
>  Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
>
>http://www.apache.org/licenses/LICENSE-2.0
>
> Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.