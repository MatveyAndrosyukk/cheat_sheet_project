package project_structure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import project_structure.models.Sensor;
import project_structure.repository.SensorRepository;
import project_structure.services.SensorService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SensorControllerTestIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SensorService sensorService;
    @Autowired
    private SensorRepository sensorRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static Sensor sensor;

    @AfterEach
    void refreshDatabase(){
        this.sensorRepository.deleteAll();
    }

    @BeforeAll
    static void initializeSensor(){
        sensor = Sensor.builder()
                .name("test_name")
                .model("test_model")
                .rangeFrom(0)
                .rangeTo(10)
                .type("test_type")
                .unit("test_unit")
                .location("test_location")
                .description("test_description")
                .build();
    }

    @Test
    @DisplayName("GET /api/sensors возвращает HTTP-ответ со статусом 200 OK и списком сенсоров")
    void handleGetAllSensorsReturnsValidResponseEntity() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/api/sensors");
        this.sensorService.save(sensor);
        this.mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("""
                                [
                                {
                                    "name": "test_name",
                                    "model": "test_model",
                                    "rangeFrom": 0,
                                    "rangeTo": 10,
                                    "type": "test_type",
                                    "unit": "test_unit",
                                    "location": "test_location",
                                    "description": "test_description"
                                }
                                ]
                                """)
                );
    }

    @Test
    @DisplayName("GET /api/sensors возвращает HTTP-ответ со статусом 200 OK")
    void handleSaveSensorReturnsValidResponseEntity() throws Exception {
        String sensorRequestJSON = objectMapper.writeValueAsString(sensor);
        this.mockMvc.perform(post("/api/sensors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sensorRequestJSON))
                .andExpect(status().isOk());
    }
}