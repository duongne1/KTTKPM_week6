- Product Service: port: 8081: http://localhost:8801/api/v1/product
- 
  ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/8ef1f4e8-5ece-4436-8038-a048955b5bfd)

- User Service: port: 8082 : http://localhost:8802/api/v2/user

![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/217dda90-ed0a-4675-b6f4-06065dbe8781)

- Discovery service: 8761

  ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/285679b3-5ecf-4fa7-9268-3bfe27283016)

- Lấy danh sách User thông qua ApiGetWay: port: 8083: http://localhost:8803/api/v2/user

  ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/98cca83e-4f97-470c-b1ec-1edb881e9bb4)

- Lấy Product thông qua ApiGetWay-Kết hợp với JWT và redis: port: 8083: http://localhost:8803/api/v1/product

  + Khi getProduct sẽ yêu cầu chứng thực:

    ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/3b36adc2-95f3-4dad-ac23-cc66bf6bd7b8)

  + Truyền username và password đến api auth/login để lấy token:
 
    ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/9dce744d-4cb6-4e57-b3d4-cb2b00e2ac72)

  + Sau đó getProduct lại kèm theo mã token vừa rồi thì sẽ lấy được product và sau đó lưu và cash Redis cho lần sau:

  ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/f0dfdd98-0d92-4038-bcd8-f0fda0cb2a7f)

  ![image](https://github.com/duongne1/KTTKPM_week6/assets/90126154/95e509d4-ca48-401e-90c5-351d9c2c24e1)







  

  
