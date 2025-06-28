# Online Store Management System

This project is a web-based system for managing an online marketplace, designed to facilitate the buying and selling of goods between users in distinct roles: buyers and vendors.
It includes detailed requirements analysis, UML modelling, database design, and a Java/Spring implementation with Hibernate persistence.

## Technical Highlights

- **Backend**: Java with Spring Framework
- **Persistence**: Hibernate ORM with JPA annotations
- **Validation**: Jakarta Bean Validation
- **Inheritance modelling**:
  - Overlapping roles via the `Roles` field
  - Dynamic employee type transitions via optional fields and methods
- **Associations**:
  - One-to-one, one-to-many, and many-to-many relationships
  - Composition relationships for richer domain modelling
- **Attribute modelling**:
  - Optional attributes using wrapper classes
  - Multi-value attributes with collections
  - Derived attributes via getters
  - Tagged values via enums

## Design Artifacts

- **Use Case Diagram**
- **Use Case Scenario and Activity Diagram**
- **State Diagram**
- **Analytical and Design Class Diagrams**
- **Dynamic Analysis**
- **GUI Mockups**

## Documentation

[Comprehensive project documentation](https://docs.google.com/document/d/15HpUh3jhmppmBEpRb7Cni8-gtpXiu8N_5NWRbcj47pM/edit?tab=t.0#heading=h.10dzw5hpncdv) is available, including detailed
design notes, UML diagrams, and implementation guidance.
