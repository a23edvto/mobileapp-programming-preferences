Först så forkades det länkade projektet. Efter det skapades en andra activity vid namn
"SharedPrefActivity" samt en xml fil vid namn "activity_shared_pref".

I activity_main skapade jag en button som gjorde att man kom till "SharedPrefActivity". Den
skrevs såhär i "activity_main":

<Button
android:text="@string/save"
android:layout_below="@+id/prefText"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:id="@+id/button"
android:onClick="savePref"/>

Sedan skrevs även såhär i "MainActivity" för att knappen skulle byta sida när man klickar på
den:

Button button = findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SharedPrefActivity.class);
        startActivity(intent);
    }
});

Efter det gjordes så att MainActivity läser in data från shared preferences och att SharedPrefActivity
skriver data till shared preferences. För att göra den senare av de två skapades en EditText i
"activity_shared_pref" som gör att man kan skriva in det man senare vill ska visas i
"MainActivity". Den skrevs såhär:

<EditText
android:id="@+id/editText"
android:layout_width="match_parent"
android:layout_height="wrap_content" />

Det skapades även en button i "activity_shared_pref" så att man kan gå till baka till
MainActivity. Den skapades på ett liknande sätt som förra knappen. Detta skrevs då i
"activity_shared_pref":

<Button
android:id="@+id/goBackButton"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Go Back"
app:layout_constraintBottom_toBottomOf="parent"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintEnd_toEndOf="parent" />

Som syns i koden så står det "Go Back" på knappen. Efter detta skrevs även en intent i
"SharedPrefActivity" som gör att man kommer till baka till MainActivity när man klickar på
knappen. Koden till den skrevs såhär:

Button button = findViewById(R.id.goBackButton);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        savePref(view);
        Intent intent = new Intent(SharedPrefActivity.this, MainActivity.class);
        startActivity(intent);
    }
});

I "activity_main" skapades även en TextView som ska visa det som skrevs in i "EditText" i 
SharedPrefActivity. Den skapades såhär:

<TextView
android:layout_below="@+id/button"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:id="@+id/prefText"
android:layout_marginTop="50dp"
android:layout_marginBottom="50dp"
tools:ignore="MissingConstraints" />

Efter detta skapades en ny metod i ""



![](android.png)
