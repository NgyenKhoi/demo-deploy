
-- =============================================
USE master

GO 

CREATE DATABASE SonyStoreDB
USE SonyStoreDB;
GO

INSERT INTO sony_categories (cate_name, cate_url, status) VALUES
(N'HeadPhone', '/headphon', 'active'),
(N'Cameras', '/cameras', 'active'),
(N'TVs', '/tivi', 'active');
GO

INSERT INTO sony_products (product_name, price, stock, created_at, updated_at, cate_id) VALUES
(N'Alpha 1 II - Full-frame Mirrorless', 6000, 3, GETDATE(), GETDATE(), 2),
(N'Alpha 7C II – Full-frame', 2000, 5, GETDATE(), GETDATE(), 2),
(N'BRAVIA 8 OLED 4K HDR TV', 2500, 10, GETDATE(), GETDATE(), 3),
(N'LinkBuds Fit Truly Wireless Noise Canceling', 180, 15, GETDATE(), GETDATE(), 1);
GO

INSERT INTO sony_accounts (full_name, password, email, phone, role_id, status) VALUES
(N'Admin', 'Admin', 'admin@sony.com', '0905111111', 1, 'active'),
(N'Staff', 'Staff', 'staff@sony.com', '0905222222', 2, 'active'),
(N'Manager', 'Manager', 'manager@sony.com', '0905333333', 3, 'active'),
(N'Customer', 'Customer', 'customer@sony.com', '0905444444', 3, 'active'),
(N'Customer1', 'Customer1', 'customer1@sony.com', '0902444444', 3, 'inactive');
