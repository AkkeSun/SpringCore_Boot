package com.example.boottest2;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MyDto {

   public interface group1 {};
   public interface group2 {};
   @Min(value = 0, message = "id는 0 이상이어야합니다", groups = {group1.class})
   private int id;

   @NotNull(message = "비밀번호는 비어있으면 안됩니다", groups = {group2.class})
   private String pwd;

}


