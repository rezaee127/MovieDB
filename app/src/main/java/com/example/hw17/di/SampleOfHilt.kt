package com.example.hw17.di

/*
---------------------------------------------------------------------------------3
//
//class SomeClass @Inject constructor(private val someOtherClass: SomeOtherClass){
//
//    fun doSomething():String{
//        return "hey i am doing something"
//    }
//
//    fun doSomeOtherThing():String{
//        return someOtherClass.doSomeOtherThing()
//    }
//}

//class SomeOtherClass @Inject constructor(){
//
//    fun doSomeOtherThing():String{
//        return "hey i am doing some other thing"
//    }
//}


/---------------------------------------------------------------------------------------------5



@Singleton
class SomeClass @Inject constructor(){

    fun doSomething():String{
        return "hey i am doing something"
    }
}

------------------------------------------------------------------5

@AndroidEntryPoint
class MyFragment: Fragment(){

    @Inject
    lateinit var someClass: SomeClass
}

@Singleton
class SomeClass @Inject constructor(){

    fun doSomething():String{
        return "hey i am doing something"
    }
}

/--------------------------------------------------------------------------5

@AndroidEntryPoint
class MyFragment: Fragment(){

    @Inject
    lateinit var someClass: SomeClass
}

@ActivityScoped
class SomeClass @Inject constructor(){

    fun doSomething():String{
        return "hey i am doing something"
    }
}

----------------------------------------------------------------------------5


@AndroidEntryPoint
class MyFragment: Fragment(){

    @Inject
    lateinit var someClass: SomeClass
}

@FragmentScoped
class SomeClass @Inject constructor(){

    fun doSomething():String{
        return "hey i am doing something"
    }
}

---------------------------------------------------------------------------------6



class SomeClass @Inject constructor(private val someDependency: SomeDependency) {
    fun doAThing(): String {
        return "Look I got: ${someDependency.getAThing()}"
    }
}

class SomeDependency @Inject constructor() {
    fun getAThing(): String {
        return "A Thing"
    }
}

-------------------------------------------------------------------------------------6

class SomeClass @Inject constructor(private val someInterfaceImpl: SomeInterface) {
    fun doAThing(): String {
        return "Look I got: ${someInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl @Inject constructor(): SomeInterface {

    override
    fun getAThing(): String {
        return "A Thing"
    }
}

interface SomeInterface{

    fun getAThing(): String
}

---------------------------------------------------------------------------------------7

@InstallIn(SingletonComponent::class)
@Module
abstract class Module{

    @Singleton
    @Binds
    abstract fun bindSomeDependency(someInterfaceImpl: SomeInterfaceImpl):SomeInterface
}

----------------------------------------------------------------------------------------------8      implementation 'com.google.code.gson:gson:2.8.9'


@InstallIn(SingletonComponent::class)
@Module
abstract class Module{

    @Singleton
    @Binds
    abstract fun bindSomeDependency(someInterfaceImpl: SomeInterfaceImpl):SomeInterface

    @Singleton
    @Binds
    abstract fun bindGson(gson: Gson):Gson
}

------------------------------------------------------------------------------------9

@InstallIn(SingletonComponent::class)
@Module
class Module{

    @Singleton
    @Provides
    fun provideSomeString():String{
        return "hello"
    }

    @Singleton
    @Provides
    fun provideSomeInterface(someString: String): SomeInterface{
        return SomeInterfaceImpl(someString)
    }

    @Singleton
    @Provides
    fun provideGson():Gson{
        return Gson()
    }
}

------------------------------------------------------------------------------------------10



@InstallIn(SingletonComponent::class)
@Module
class Module{

    @Impl1
    @Singleton
    @Provides
    fun provideSomeInterface1(): SomeInterface{
        return SomeInterfaceImpl1()
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterface2(): SomeInterface{
        return SomeInterfaceImpl2()
    }
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2


---------------------------------------------------------------------------------------

//hilt
implementation 'com.google.dagger:hilt-android:2.38.1'
kapt 'com.google.dagger:hilt-android-compiler:2.38.1'

implementation 'com.google.code.gson:gson:2.8.9'

id 'dagger.hilt.android.plugin'

id 'com.google.dagger.hilt.android' version '2.41' apply false


https://developer.android.com/training/dependency-injection/hilt-android#android-classes

*/

