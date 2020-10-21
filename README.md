<h1 align="center">Super Toolbar</h1>
<p align="center">Android native toolbar on steroids 💪</p>
<p align="center">
  <a href="https://travis-ci.org/andrefrsousa/SuperToolbar"><img src="https://travis-ci.org/andrefrsousa/SuperToolbar.svg?branch=master" alt="Build Status"></a>
  <a href="https://jitpack.io/#andrefrsousa/SuperToolbar"><img src="https://jitpack.io/v/andrefrsousa/SuperToolbar.svg" alt="jitpack"></a>
  <a href="https://android-arsenal.com/api?level=14"><img src="https://img.shields.io/badge/API-14%2B-orange.svg?style=flat" alt="api"></a>
  <a href="https://android-arsenal.com/details/1/7261"><img src="https://img.shields.io/badge/Android%20Arsenal-SuperBottomSheet-green.svg?style=flat" alt="Android Arsenal"></a>
</p>
  
### Summary  

* Animate the height of the toolbar as you scroll
* Center the toolbar title horizontally
* Use light title font

It was written **100% in Kotlin** ❤️

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
    implementation 'com.github.andrefrsousa:SuperToolbar:1.2.0'
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

  
## Customization
  
You can costume your toolbar with the following attributes:

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
The MIT License (MIT)  
  
Copyright (c) 2018 André Sousa  
  
Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:  
  
The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.  
  
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.
