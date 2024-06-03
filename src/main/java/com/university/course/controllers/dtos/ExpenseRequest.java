package com.university.course.controllers.dtos;

import java.math.BigDecimal;

public class ExpenseRequest {
    private String description;
    private BigDecimal amount;
    private String date;
    private Long user_id;

    public String getDescription() {
      return this.description;
    }
    public void setDescription(String value) {
      this.description = value;
    }

    public BigDecimal getAmount() {
      return this.amount;
    }
    public void setAmount(BigDecimal value) {
      this.amount = value;
    }

    public String getDate() {
      return this.date;
    }
    public void setDate(String value) {
      this.date = value;
    }

    public Long getUser_id() {
      return this.user_id;
    }
    public void setUser_id(Long value) {
      this.user_id = value;
    }
}
