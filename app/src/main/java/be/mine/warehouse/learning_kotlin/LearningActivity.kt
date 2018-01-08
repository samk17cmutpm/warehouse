package be.mine.warehouse.learning_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import be.mine.warehouse.R

class LearningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)
        val customer = Customer("Nguyen Van Sam")
        customer.abc
        val person = Person("abc", "def", 4)
        person.age = 10
        person.firstName = "Bui Xuan The"
        person.secondName = "Ngo Van Trung"
        val anotherCustomer = Customer("DPLH", customer)
        anotherCustomer.abc
    }

}
