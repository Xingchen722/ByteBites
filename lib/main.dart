import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_gen/gen_l10n/app_localizations.dart';
import 'package:flutter_application_1/screens/login_screen.dart';
import 'screens/register_screen.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:flutter_application_1/pages/canteen_queue_page.dart';

void main() {
  runApp(const ByteBitesApp());
}

class ByteBitesApp extends StatefulWidget {
  const ByteBitesApp({super.key});

  @override
  State<ByteBitesApp> createState() => ByteBitesAppState();
}

class ByteBitesAppState extends State<ByteBitesApp> {
  Locale _locale = const Locale('en'); // 当前语言环境，默认为英文

  @override
  void initState() {
    super.initState();
    _loadSavedLanguage(); // 初始化时加载已保存的语言设置
  }

  // 从本地存储加载用户的语言偏好
  Future<void> _loadSavedLanguage() async {
    final prefs = await SharedPreferences.getInstance();
    final currentUsername = prefs.getString('currentUsername');
    if (currentUsername != null) {
      final savedLanguage = prefs.getString('language_$currentUsername');
      if (savedLanguage != null) {
        setState(() {
          _locale = Locale(savedLanguage);
        });
      }
    }
  }

  // 切换语言
  void changeLanguage(Locale newLocale) {
    setState(() {
      _locale = newLocale;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'ByteBites',
      theme: ThemeData.dark(), // 使用暗色主题
      locale: _locale, // 当前语言环境
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      supportedLocales: const [
        Locale('en'), 
        Locale('zh'), 
      ],
      home: LoginScreen(), // 默认首页为登录页
      routes: {
        '/login': (context) => const LoginScreen(), // 登录页路由
        '/register': (context) => const RegisterScreen(), // 注册页路由
        '/canteen_queue': (context) => CanteenQueuePage(), // 食堂排队页路由
      },
    );
  }
}

// 商家信息
class Vendor {
  final String id;
  final String name;
  final String description;
  final String address;
  final String openingHours;
  final String logoUrl;
  // ...
  Vendor({
    required this.id,
    required this.name,
    required this.description,
    required this.address,
    required this.openingHours,
    required this.logoUrl,
    // ...
  });
}
