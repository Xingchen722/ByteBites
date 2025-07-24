import 'package:http/http.dart' as http;
import 'dart:convert';

class CanteenService {
  static Future<List<dynamic>> fetchCanteens() async {
    final response = await http.get(Uri.parse('http://localhost:8080/canteens'));
    if (response.statusCode == 200) {
      return jsonDecode(response.body);
    } else {
      throw Exception('Failed to load canteens');
    }
  }
} 