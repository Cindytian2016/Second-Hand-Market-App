import React, { useState } from 'react';
import './transaction.css'; // Importing the CSS for styling

const Transaction = () => {
    const [transaction, setTransaction] = useState({
        buyerName: '',
        sellerName: '',
        item: '',
        amount: ''
    });

    // Handles input change
    const handleChange = (e) => {
        const { name, value } = e.target;
        setTransaction(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    // Handles form submission
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Transaction Details:', transaction);
        // Submit the transaction details to your backend server
    };

    return (
        <div className="transaction">
            <h2>Complete Transaction</h2>
            <form onSubmit={handleSubmit} className="transactionForm">
                <input
                    type="text"
                    name="buyerName"
                    placeholder="Buyer's Name"
                    value={transaction.buyerName}
                    onChange={handleChange}
                    required
                />
                <input
                    type="text"
                    name="sellerName"
                    placeholder="Seller's Name"
                    value={transaction.sellerName}
                    onChange={handleChange}
                    required
                />
                <input
                    type="text"
                    name="item"
                    placeholder="Item Name"
                    value={transaction.item}
                    onChange={handleChange}
                    required
                />
                <input
                    type="number"
                    name="amount"
                    placeholder="Transaction Amount"
                    value={transaction.amount}
                    onChange={handleChange}
                    required
                />
                <button type="submit">Submit Transaction</button>
            </form>
        </div>
    );
};

export default Transaction;
