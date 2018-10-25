# SuperToolbar
Android native Toolbar on steroids 💪

## Specs  
[![](https://jitpack.io/v/andrefrsousa/SuperBottomSheet.svg)](https://jitpack.io/#andrefrsousa/SuperToolbar) [![API](https://img.shields.io/badge/API-14%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=14) [![Build Status](https://travis-ci.org/andrefrsousa/SuperToolbar.svg?branch=master)](https://travis-ci.org/andrefrsousa/SuperToolbar) [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SuperToolbar-green.svg?style=flat )]( https://android-arsenal.com/details/1/7261 )

Animate the toolbar elevation when scrolling.
It has been written **100% in Kotlin**. ❤️  

## Download  
  
This library is available in **jitpack**, so you need to add this repository to your root build.gradle at the end of repositories:
   
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
    implementation 'com.github.andrefrsousa:SuperToolbar:{latest_version}'
}
```  

## Sample Project  

We have a sample project in Kotlin that demonstrates the lib usages [here](https://github.com/andrefrsousa/SuperToolbar/blob/master/demo/src/main/java/com/andrefrsousa/supertoolbar/demo/DemoActivity.kt).

![](/raw/example.gif)

## Usage  

It is recommended to check the sample project to get a complete understanding of all the features offered by the library.  
In order to show the toolbar elevation you just need to call:

```kotlin
fun setElevationVisibility(show: Boolean)
```  

If what to have the same effect found in Google Messages app for example, you to add a scroll listener to your RecyclerView or ScrollView.
An on the callback of the listener you use the method above.

Here is an example:

```kotlin

myRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        toolbar.setElevationVisibility(recyclerView.canScrollVertically(-1))
    }
})

```

  
## Customization
  
The are a group of general properties that you can define. These properties will be applied to all the SuperBottomSheet in your project.  

```xml

// The duration of the elevation animation. By default if 250 miliseconds.
<attr name="superToolbar_animationDuration" format="integer"/>

// If you want to show the toolbar elevation when created. By default it start hidden.
<attr name="superToolbar_showElevationAtStart" format="boolean"/>

```

## Spread Some :heart:  
[![GitHub followers](https://img.shields.io/github/followers/andrefrsousa.svg?style=social&label=Follow)](https://github.com/andrefrsousa)  [![Twitter Follow](https://img.shields.io/twitter/follow/andrefrsousa.svg?style=social)](https://twitter.com/andrefrsousa)
  
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
