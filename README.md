### Comparsion of pull & push based Flux creation

|                      | Flux.create()                                                                                                                                                                        | Flux.generate()                                                                                                       |
|----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Push/Pull Based**  | Push-based: Elements are pushed to the consumer.                                                                                                                                     | Pull-based: Elements are pulled by the consumer on demand.                                                            |
| **Backpressure**     | Manually handled: The method accepts an `OverflowStrategy`, but it's the developer's responsibility to respect backpressure.                                                         | Inherently supported: As it is pull-based, it only generates a new element when the consumer signals demand for it.   |
| **Threading**        | Multithreading support: Can generate elements asynchronously from multiple threads.                                                                                                  | Single-threaded: Elements are generated synchronously one at a time.                                                  |
| **Use Case Example** | Real-time dashboard updates: If you have a scenario where you care about the latest updates (such as real-time analytics), and can afford to lose some data in periods of high load. | Chat application: When you never want to lose a message and each message should be processed in the order it arrived. |

