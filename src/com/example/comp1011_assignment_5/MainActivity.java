/**
 * @author chandan Dadral
 * @Version: 1.0 April 01, 2015
 * @Description: This Application was desined to give the value of BMI. User can Select Imperial and
 *					Metric Units and it gives the Value of BMI 
 */
package com.example.comp1011_assignment_5;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
 
public class MainActivity extends Activity {
	
	//initialised Private Variables
	private float _height;
	private float _weight;
	private float _bmi;
	private String _select;
	private EditText _weightEditText;
	private EditText _heightEditText;
	private TextView _resultView;
	private TextView _bodyType;
	private RadioGroup _radioGroup;
	private RadioButton _selectedButton;
	private Button _calculate;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        
        this._weightEditText = (EditText) findViewById(R.id.weightText);
        this._heightEditText = (EditText) findViewById(R.id.heightText);
        this._resultView = (TextView) findViewById(R.id.resultLabel);
        this._bodyType = (TextView) findViewById(R.id.bodyType);
        this._calculate = (Button) findViewById(R.id.calculateButton); 
        this._radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        
    }
	
    public void calculateClickHandler(View view) {
    	
    	int id = this._radioGroup.getCheckedRadioButtonId();
	    this._selectedButton = (RadioButton) findViewById(id);
	    this._select = (String) this._selectedButton.getText();
	    
    //to handle the Calculate Button
     if (view.getId() == R.id.calculateButton) {
    	
 
     //Getting the User Inputs 
       this._weight = Float.parseFloat(_weightEditText.getText().toString());
       this._height = Float.parseFloat(_heightEditText.getText().toString());
 
      // calculate the bmi value
      float bmiValue = calculateBMI(this._weight, this._height);
 
      // interpret the meaning of the bmi value
      String check = bmiCheck(bmiValue);
 
      //  set the value in the result text
      _resultView.setText("Bmi" + bmiValue  );
      
      _bodyType.setText("Body Type - " + check);
      
     }
    }

    /**
     * This Functions calculates the User BMI 
     * @param weight - weight of the user
     * @param height- height of the User
     * @return BMI
     */
    private float calculateBMI (float weight, float height) {
    	
    	//If imperial is Selected 
    	if(this._select.equals("Imperial")){
    		this._bmi = ((this._weight * 703) / (this._height * this._height));
    	}
    	//if MEtric units are Selected
    	else if (this._select.equals("Metric")){
    		
    		this._bmi = (this._weight / (this._height * this._height));
    	}
    	return this._bmi;
    	
}

 
   /**
    * This Function Checks the range of the BMI and tells the Body Type 
    * @param bmiValue
    * @return Body Type
    */
    private String bmiCheck(float bmiValue) {

     if (bmiValue < 18.5) {
      return "Underweight";
     } else if (bmiValue >= 18.5 && bmiValue <=24.9) {

      return "Normal";
     } else if (bmiValue >= 25 && bmiValue <=29.9) {

      return "Overweight";
     } else if (bmiValue > 30) {

      return "Obese";
     } else {
      return "Obese";
     }

    }
}