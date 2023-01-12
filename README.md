# AndroidProject

Pour le SplashScreen -> Ne pas oublier dans le manifest de mettre <intent-filter> sur la page SplashScreen et non plus sur MainActivity pour qu'il se lance 

Pour le Menu de Navigation -> Ne pas oublier dans build.gradle (Module:app) de mettre : 
 buildFeatures{
        viewBinding true
    }
