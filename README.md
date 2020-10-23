<h1 align="center">Super Toolbar</h1>
<p align="center">Android native toolbar on steroids 💪</p>
<p align="center">
  <a href="https://github.com/andrefrsousa/SuperToolbar/actions?query=workflow%3A%22Android+CI%22"><img src=https://github.com/andrefrsousa/SuperToolbar/workflows/Android%20CI/badge.svg?branch=master" alt="Build Status"></a>
  <a href="https://jitpack.io/#andrefrsousa/SuperToolbar"><img src="https://jitpack.io/v/andrefrsousa/SuperToolbar.svg" alt="jitpack"></a>
  <a href="https://android-arsenal.com/api?level=14"><img src="https://img.shields.io/badge/API-14%2B-orange.svg?style=flat" alt="api"></a>
</p>
  
### Summary  

* Animate the height of the toolbar as you scroll
* Center the toolbar title horizontally
* Use light title font


## Download  
  
This library is available in **jitpack**, so to use it you need to add the above statement to your root *build.gradle*:
   
```groovy  
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
	
Add the dependency:

```groovy 
dependencies {
    implementation 'com.github.andrefrsousa:SuperToolbar:1.3.0'
}
```  

## Sample Project  

We have a sample project in Kotlin that demonstrates the use of the library [here](https://github.com/andrefrsousa/SuperToolbar/blob/master/demo/src/main/java/com/andrefrsousa/supertoolbar/demo/DemoActivity.kt).

![](/raw/example.gif)

## Use  

It is recommended that you review the sample project to get a full understanding of all the features offered by the library. 
To display the height of the toolbar, you only need to call:

```kotlin
fun setElevationVisibility(show: Boolean)
```  

If you want to have the same effect as the one used in Google Messages, for example, add a scroll listener to your *RecyclerView* or *ScrollView*. Like this:

```kotlin

myRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        toolbar.setElevationVisibility(recyclerView.canScrollVertically(-1))
    }
})

```

  
## Adjustments
  
You can costumize your toolbar with the following attributes:

```xml

// The duration of the elevation animation. By default it is 250 miliseconds.
<attr name="superToolbar_animationDuration" format="integer"/>

// If you want to show the toolbar elevation when created. By default is false.
<attr name="superToolbar_showElevationAtStart" format="boolean"/>

// Center the toolbar title. Is false by default.
<attr name="superToolbar_centerTitle" format="boolean"/>

// Use a light font as the title of the toolbar. The default value is false.
<attr name="superToolbar_useLightFont" format="boolean"/>

```
  
## License  
  
```
Copyright (c) 2018 André Sousa  

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
