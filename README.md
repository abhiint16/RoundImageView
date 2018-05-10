# RoundImageView
This is a library that provides a RoundView with a text at the center. You can change the color of the roundview as well as the text. 

To use this library, add the dependency in the module level **build.gradle** file.

      implementation 'abhishek.com.roundimage:roundimage:1.0.0'

Now you can add the view by writing,

      <abhishekint.com.roundimage.RoundImageView
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:id="@+id/round_image"
        custom:circleColor="@color/colorAccent"
        custom:circleText="@string/app_name"
        custom:circleTextColor="#fff"
        android:src="@drawable/ic_launcher_background"/>
        
        
 Happy coding!
