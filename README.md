# Binance Tester Application

## Overview
The **Binance Tester Application** is a Spring Boot service designed to evaluate and compare the performance of two endpoints provided by the `BinanceController` application:
1. **Cache-enabled endpoint**: Fetches cryptocurrency prices from the in-memory cache.
2. **Real-time endpoint**: Fetches cryptocurrency prices directly from the Binance API.

The application sends multiple requests to both endpoints, measures response times, and generates a performance report detailing:
- **Average response time**
- **Best (minimum) response time**
- **Worst (maximum) response time**

---

## Features
- **Performance Testing**: Tests and measures response times for cache-enabled and real-time API calls.
- **Detailed Metrics**: Provides insights into the efficiency of cache usage versus direct API calls.
- **RESTful API**: Exposes a `/compare` endpoint for generating performance reports.
- **Error Handling**: Logs failures during testing without interrupting the entire process.

---

## API Documentation

### Endpoint: `POST /compare`

Compares the performance of cache-enabled and real-time endpoints for a specified trading pair.

#### Parameters
1. **Query Parameter**:
    - `symbol` (required): The trading pair symbol (e.g., `BTC-USD`, `ETH-USD`).

#### Example Request
```bash
curl -X POST "http://localhost:8080/compare?symbol=BTC-USD"
```

#### Example Response
```
{
"cachePerformance": {
"averageTime": 150000.0,
"bestTime": 120000,
"worstTime": 200000
},
"realTimePerformance": {
"averageTime": 300000.0,
"bestTime": 250000,
"worstTime": 400000
}
}
```