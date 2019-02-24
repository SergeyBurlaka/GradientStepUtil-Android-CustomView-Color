# GradientStep

![](https://github.com/SergeyBurlaka/GradientStep/blob/master/app/art/1.jpg)


I have wrote the [StepGradientUtil class](https://github.com/SergeyBurlaka/GradientStepUtil-Android-CustomView-Color/blob/master/app/src/main/java/com/b5eg/stepgradient/StepGradientUtil.kt) for calculate colors gradient.

via very, very simple Kotlin code:

```kotlin
    val pink = Colar(245, 9, 253)
    val lime = Colar(0, 253, 32)

    lp_1.colors = (pink toColor lime).run {
        gradient { 0 upTo 3 }
    }

    lp_2.colors = (pink toColor lime).run {
        gradient { 0 upTo 9 }
    }

    lp_3.colors = (pink toColor lime).run {
        gradient { 3 upTo 9}
    }
```
