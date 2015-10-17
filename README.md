# REST-vs-BPEL

This project was made by D. González, A.Gherman, M. Gordo, P.E. Dalidec and S. Hsaini as a project for the Web Services course at DTU, 2013-2014.

The project presents a travel company called TravelGood. This company offers a web service through which customers can browse flights and hotels, make reservations for a trip, make payments for a reservation, or cancel at any time during the process.
The flights are offered by LameDuck, a flight registration company, and the hotels are offered by NiceView, a hotel reservation company. These are SOAP based Web Services. The payments are managed through FastMoney, another SOAP based Web Service.

The goal of this project was to implemet LameDuck and NiceView as SOAP web services, and TravelGood as both BPEL and RESTful web services, in order to compare and understand both approaches.
Other smaller requisites of the project involved concepts such as WSDL, WSIL, UDDI, Web Services coordination...

Both REST and BPEL implementations are Netbeans projects, and their respective tests projects are released as Netbeans proyects and should be deployed as such. You can find more info on how to build and deploy Web Services in Netbeans here: https://netbeans.org/kb/docs/websvc/jax-ws.html#Exercise_2_1

NOTE: this project manages payment through an external web service provided by the then-teacher of the course, at http://fastmoney.imm.dtu.dk:8080, which might not be reachable anymore, and so payments may result in error

The final report can be found in web-services-final.pdf.


