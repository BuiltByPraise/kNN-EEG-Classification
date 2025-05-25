# k-Nearest Neighbours (kNN) Classifier – Java

A Java-based implementation of the k-Nearest Neighbours (kNN) algorithm designed to classify biological data using Euclidean distance.

---

##  Features

- Reads and parses numerical training and test data from `.txt` files
- Computes Euclidean distances between feature vectors
- Classifies based on `k` nearest neighbours (default `k=3`)
- Outputs predicted labels to `output.txt`
- Calculates classification accuracy against true labels

---

## Tech Stack

- **Language**: Java
- **Core Concepts**: kNN algorithm, Euclidean distance, file I/O, array manipulation
- **Input/Output**:
  - `train_data.txt` and `train_label.txt`
  - `test_data.txt` and `test_label.txt`
  - Output: `output.txt`

---
kNN-EEG-Classification/
├── kNN1.java # Main classifier implementation
├── train_data.txt # Training feature vectors
├── train_label.txt # Labels for training data
├── test_data.txt # Testing feature vectors
├── test_label.txt # Ground truth for test data
├── output.txt # Output predictions
├── README.md # Project overview

## Files Included
